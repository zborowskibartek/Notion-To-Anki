# Notion To Anki

## 🗒️ Overview

The project is implemented mainly for learning purposes and to speed up the process of creating flashcards. As a big fan of the Notion and Anki apps, I decided to do it in a more convenient way. For now, importing cards from Notion databases into the Anki decks is done via HTTP communication.

## ⚠️ Remarks

- *Notion* → due to fact that the official Notion API has not been implemented yet, currently communication takes place from the exported `*.html` file. Full **instruction** on how to properly download the file is provided **below**.
- *Anki* → since Anki do not support communication via web browser . Hence, you are obligated to download desktop version and install predefined plugin to be able to send data to your account. As before entire **information** about it is listed **beneath**.

## ⚙️ Installation

To start the application, follow the steps below. Additionally, make sure that you have free two local ports `8080` and `8765`:

- Clone the project:

`git clone https://github.com/zborowskibartek/Notion-To-Anki.git`

- Build and run application:

`gradle bootRun`

## ☄️ **Getting Started**

At this point, the application performs a simple operation - data transfer. To ensure appropriate work, complement request body with presented format.

**POST →** transfer all flashcards (must contain **body** request)

`http://localhost:8080/flashcards/transfer`

JSON **body**:

```json
{
   "deckName": "SampleAnkiDeckName",
   "modelName": "Basic",
   "allowDuplicate": false,
   "questionColumn": "cell-title",
   "answerColumn": "cell-Mk~d",
   "table": "Dictionary.html"
}
```

|Key               |Value                            |Descirption                                          |Future chagnes*         |
|------------------|---------------------------------|-----------------------------------------------------|------------------------|
|"deckName"        |"SampleAnkiDeckName"             |existing target deck                                 |                        |
| "modelName"      |"Basic"                          |flashcard type - Q&A                                 |                        |
|                  |"Basic (and reversed card)"      |flashcard type - Q&A and A&Q                         |                        |
|"allowDuplicate"  |false                            |disable add duplicates - check entire collection     |                        |
|                  |true                             |enable add duplicates - check entire collection      |                        |
|"questionColumn"  |"daasda"                         |class name of cell storing question                  |question colmn id       |
|"answerColumn"    |"daasda"                         |class name of cell storing answer                    |answer column id        |
|"table"           |"Dictionary.html"                |exported .html file name                             |table id                |
- *will be valid after the introduction of full communication over HTTP

## 🛠️ Manual (will be deprecated when Notion open its API)

- Export **table** or **page with nested table** (but with only one table inside particular Notion page)

![https://i.ibb.co/hZBdtNm/Manula-Notion-To-Anki-01.jpg](https://i.ibb.co/hZBdtNm/Manula-Notion-To-Anki-01.jpg)

![https://i.ibb.co/47mh8xK/Manula-Notion-To-Anki-02.jpg](https://i.ibb.co/47mh8xK/Manula-Notion-To-Anki-02.jpg)

- Open exported file via any browser, press F12 and find names of marked classes (one for **question** and second for an **answer**, be aware since values may differ in your file)

![https://i.ibb.co/znQkSPb/Manula-Notion-To-Anki-03-1.jpg](https://i.ibb.co/znQkSPb/Manula-Notion-To-Anki-03-1.jpg)

- Fulfill **request body** with appropriate values (for keys: `"questionColumn"`, `"answerColumn"`) and POST request :)

## **⌨️ Technology Stack**

- **Spring Boot**
- **Jsoup**
- **Gson**

## 🗻 **Future Improvements**

I have been enrolled since the end of 2020 for beta test Notion public API, but unfortunately I am still waiting to access it. I hope they will release it soon. Thanks of that, I'm going to provide communication via user account and its nested databases via HTTP not only from exported file.
