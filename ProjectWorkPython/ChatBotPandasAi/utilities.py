# utilities.py
import pandas as pd
import streamlit as st # streamlit è un modulo per l'interfaccia grafica
from pandasai import Agent # dal metodo pandas importo Agent (l'IA)
import os

def insert_csv_to_df(csv_file):
    if csv_file is not None:
        df = pd.read_csv(csv_file, error_bad_lines=False)
        return df
    return None


# pagina del contesto - 
# da un contesto all'IA cosi l'informazione che cerca è precisa in base al contesto
def data_context_page():
    st.title("Contesto Chatbot")
    st.markdown("<h2 style='text-align: center;'>Inserisci il contesto per l'analisi dei dati</h2>", unsafe_allow_html=True) # box del testo del contesto
    st.write("Questo contesto sarà utilizzato come base per le domande che porrai al chatbot.")

    contesto = st.text_area("Descrivi il contesto (opzionale)", help="Aggiungi dettagli che vuoi che il chatbot conosca per l'analisi dei dati.")
    
    if contesto:
        st.session_state['context'] = contesto
        st.success("Contesto salvato con successo!")


# pagina dell'analisi 
def data_analysis_page():
    st.title("Analisi dei Dati")
    st.markdown("<h2 style='text-align: center;'>Carica il file CSV e fai domande sull'analisi dei dati</h2>", unsafe_allow_html=True)
    
    file_caricato = st.file_uploader("Carica un file .csv", type="csv", help="Carica un file CSV per visualizzare e analizzare i dati") # button per il fine csv da caricare

    if file_caricato is not None: # se non trova il file csv lo inserisce nel data frame
        df = insert_csv_to_df(file_caricato)
        st.write("Anteprima del DataFrame caricato:")
        st.dataframe(df)

        os.environ["PANDASAI_API_KEY"] = "$2a$10$c0zbOYe9rlfJKoJpbCFEwusgv3oA.7dFWz1BHwmbtQqgzQf8XK3C."

        agent = Agent(df) # passiamo il data frame a Agent

        query = st.text_input("In cosa posso esserti utile?", help="Fai una domanda al chatbot per analizzare i dati.") # box per porre le domande all'IA

        if query: # la risposta di Agent viene data in base al contesto scritto
            prompt_completo = f"{st.session_state['context']} {query}"
            risposta = agent.chat(prompt_completo)
            st.write("Risposta del chatbot:", risposta)
            st.write("Il chatbot ti è stato utile?")

            # Variabili di stato per il contesto e il feedback
            if st.button("👍"):  # se il feedback è positivo
                    st.success("Grazie per il tuo feedback positivo!")
                    st.session_state['feedback_given'] = True
            elif st.button("👎"):  # se il feedback negativo
                    st.warning("Ci dispiace! Il tuo feedback è stato registrato.")
                    st.session_state['feedback_given'] = True
    else:
        st.warning("Carica un file CSV per visualizzare e analizzare i dati.")