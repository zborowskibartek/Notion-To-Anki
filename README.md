# Info

 Simple project to help creating flashcards, due to connect two Apps Notion and Anki. Recently based on exported file from Notion (*.html) and desktop version of Anki. Curently I am waiting for open Notion API to provide direct communication between Notion "databses" and Anki PC app.

## Pre-requisites

- Anki (desktop version, with plugin Anki Connect)
- You should be familiar with Notion app (simple knowledge about its "databases")
- Exported file from Notion (page should be based on Notion databases, more details below)


## Getting Started

Clone repo straightforward to destination directory and open through your IDE. The communication between app and Anki goes through HTTP on http://localhost:8765/. You are obligated to provide question and answer cell name from exported file to perform appropirate parsing to Java object.

Step by step to prepare exported file and find cell names:

- Create simple database

![https://i.ibb.co/4jHJLBd/Screenshot-2021-04-11-13-31-26.jpg](https://i.ibb.co/4jHJLBd/Screenshot-2021-04-11-13-31-26.jpg)

- Export file to HTML

![https://i.ibb.co/tzNZRxZ/Screenshot-2021-04-11-13-47-48.jpg](https://i.ibb.co/tzNZRxZ/Screenshot-2021-04-11-13-47-48.jpg)

- Open file in browser and open tools for developers (then find cell names as below)

![https://i.ibb.co/VghT4Lx/Screenshot-2021-04-11-13-50-19.jpg](https://i.ibb.co/VghT4Lx/Screenshot-2021-04-11-13-50-19.jpg)

After all, open Anki app and create destination deck (as before, set new deck name in source code -> static variable).

## ⌨️ Technology Stack

The project uses the following libraries:

- **Lombok**
- **Gson**
- **PostgreSQL**
- **ApacheHttp Client**
- **JSoup**

## ⚠️ Project Status

Currently perform communication between exported file from Notion to desktop version of Anki. I am signed up for the beta test of Notion API, to ensure connection via HTTP.
