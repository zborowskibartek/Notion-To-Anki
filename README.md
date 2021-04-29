# Notion To Anki

## 🗒️ Overview

The project is implemented mainly for learning purposes and to speed up the process of creating flashcards. As a big fan of the Notion and Anki apps, I decided to do it in a more convenient way. For now, importing cards from Notion databases into the Anki decks is done via HTTP communication.

## ⚠️ Remarks

- *Notion* → due to the fact that the official Notion API has not been implemented yet, currently communication takes place from the exported `*.html` file. Full **instruction** on how to properly download the file is provided **below**.
- *Anki* → since Anki do not support communication via web browser . Hence, you are obligated to download desktop version and install predefined plugin to be able to send data to your account. As before entire information about it is listed beneath.

## ⚙️ Installation

Let's go through the following steps to get the application running. Additionally, make sure that you have free two local ports `8080` and `8765`:

- Clone the project:

`git clone https://github.com/zborowskibartek/Notion-To-Anki.git`

- Build and run application:

`gradle bootRun`

## ☄️ **Getting Started**

...
