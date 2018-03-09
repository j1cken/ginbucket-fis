# ginbucket-fis
This project implements a camel route providing a REST endpoint to send messages to a Telegram chat. The message flow is decoupled by using AMQ inbetween.
The main idea here is to have another route getting notifications about changes in SF using the Streaming API.
