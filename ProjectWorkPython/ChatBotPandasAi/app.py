import os
import streamlit as st
import pandas as pd
from pandasai import Agent
from utilities import insert_csv_to_df, data_context_page, data_analysis_page

st.set_page_config(layout="wide")

# CSS per personalizzare lo stile
st.markdown("""
    <style>
    /* Sfondo principale nero */
    .css-1d391kg {
        background-color: #000000;
    }

    /* Corpo della pagina */
    .css-1aumxhk {  /* Classe della barra laterale */
        background-color: #111111;
    }
    
    /* Sfondo del corpo e dei pannelli */
    .css-1v3fvcr {
        background-color: #000000;
    }
    
    /* Testo e titoli verdi */
    h1, h2, h3, h4, h5, h6 {
        color: #00FF00;
    }

    /* Testo di input e label verde */
    .stTextInput > div > label,
    .stTextArea > div > label {
        color: #00FF00;
    }

    /* Pannello dei dati */
    .stDataFrame {
        color: #00FF00;
        background-color: #111111;
    }

    /* Bottoni e feedback */
    .stButton > button {
        background-color: #00FF00;
        color: #000000;
        border: none;
    }

    .stButton > button:hover {
        background-color: #00CC00;
        color: #FFFFFF;
    }

    /* Avvisi */
    .stAlert > div {
        background-color: #111111;
        color: #00FF00;
    }
    </style>
    """, unsafe_allow_html=True)


if 'context' not in st.session_state: 
    st.session_state['context'] = ""
if 'feedback_given' not in st.session_state: 
    st.session_state['feedback_given'] = False


# Menu di navigazione nella barra laterale
st.sidebar.title("Navigazione")
page = st.sidebar.selectbox("Seleziona la pagina", ("Contesto", "Analisi Dati"))

# Logica per visualizzare la pagina selezionata
if page == "Contesto":
    data_context_page()
elif page == "Analisi Dati":
    data_analysis_page()
