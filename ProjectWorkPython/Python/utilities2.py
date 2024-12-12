import os
import re
import io
from wordcloud import WordCloud

def conta_occorrenze_parole(testo, file_stopwords="italian.txt"):
    # Ottieni il percorso relativo per italian.txt
    file_stopwords = os.path.join(os.path.dirname(__file__), file_stopwords)

    with open(file_stopwords, "r", encoding="utf-8") as f:
        stopwords = set(f.read().split())

    parole = re.findall(r'\b\w+\b', testo.lower())
    conteggi_parole = {}

    for parola in parole:
        if parola not in stopwords:
            if parola in conteggi_parole:
                conteggi_parole[parola] += 1
            else:
                conteggi_parole[parola] = 1

    parole_ordinate = sorted(conteggi_parole.items(), key=lambda item: item[1], reverse=True)[:10]

    return dict(parole_ordinate)

def genera_wordcloud(conteggio_parole):
    wordcloud = WordCloud(width=800, height=400, background_color='#b19ff9', colormap="plasma").generate_from_frequencies(conteggio_parole)
    img_buf = io.BytesIO()
    wordcloud.to_image().save(img_buf, format="PNG")
    img_buf.seek(0)
    return img_buf
