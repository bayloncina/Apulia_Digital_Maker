import os
import streamlit as st
import matplotlib.pyplot as plt
from utilities2 import conta_occorrenze_parole, genera_wordcloud
from wordcloud import WordCloud
import io

# Configura la pagina
icon_path = os.path.join(os.path.dirname(__file__), "hand.png")
st.set_page_config(layout="wide", page_title="ContaParole", page_icon=icon_path)

# CSS per cambiare il colore del bottone
st.markdown(
    """
    <style>
    div.stButton > button {
        background-color: #ff9800;
        color: white;
        border-radius: 10px;
        padding: 0.5em 1em;
        font-weight: bold;
        border: none;
        cursor: pointer;
    }
    div.stButton > button:hover {
        background-color: white;
        color: #ff9800;
    }
    </style>
    """,
    unsafe_allow_html=True
)

st.markdown(
    """
    <style>
    /* Imposta il colore di sfondo della pagina */
    .stApp {
        background-color: #b19ff9; /* Cambia il colore come preferisci */
    }
    </style>
    """,
    unsafe_allow_html=True
)

# Titolo
st.markdown("<h1 style='text-align: center;'>Conteggio delle Occorrenze delle Parole</h1>", unsafe_allow_html=True)

# Definisci le colonne
col1, col2 = st.columns([1, 2])

with col1:
    # Area di testo e caricamento file
    st.text_area("Copia e incolla testo", height=200, key="text_area", label_visibility = "collapsed", placeholder="Inserisci il testo qui...")
    uploaded_file = st.file_uploader("Oppure carica un file .txt", type="txt", label_visibility="visible", help="Carica un file di testo per contare le parole")

    user_text = st.session_state.text_area or (uploaded_file.read().decode("utf-8") if uploaded_file else "")

    # Bottone per conteggio parole
    if st.button("Conteggia parole"):
        if user_text:
            word_counts = conta_occorrenze_parole(user_text)

            st.markdown(
                "<div class='result-box'>"
                "<h4>Conteggio delle parole:</h4>"
                + "".join([f"<p style='color: black;'>{word}: {count}</p>" for word, count in word_counts.items()])
                + "</div>",
                unsafe_allow_html=True,
            )
        else:
            st.warning("Inserisci del testo o carica un file .txt per contare le parole.")

with col2:
    # Grafico e wordcloud
    if 'word_counts' in locals() and word_counts:
        fig, ax = plt.subplots()
        fig.patch.set_facecolor('grey')
        ax.set_facecolor('#1e1e1e')
        bars = ax.bar(word_counts.keys(), word_counts.values(), color="#ff9800")
        plt.xticks(rotation=45, ha='right', fontsize=12)
        plt.xlabel("Parole", color="white", fontsize=14)
        plt.ylabel("Occorrenze", color="white", fontsize=14)
        ax.spines['bottom'].set_color('white')
        ax.spines['left'].set_color('white')
        ax.tick_params(axis='x', colors='#ff9800')
        ax.tick_params(axis='y', colors='#ff9800')


        plt.tight_layout()
        st.pyplot(fig)

        wordcloud_image = genera_wordcloud(word_counts)
        st.image(wordcloud_image, use_container_width=True)








