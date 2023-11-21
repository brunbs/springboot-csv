# springboot-csv
Little project to show how to return a CSV from an endpoint.

In this project I've implemented a way to return a CSV file in java spring boot.

This project was built as a tutorial that you can find in this article:

[https://dev.to/brunbs/how-to-return-paginated-data-in-spring-boot-11cm](https://dev.to/brunbs/java-spring-boot-retuning-a-csv-file-from-an-endpoint-1803)

Sometimes we'll need to return files to our clients browser, in this repository I show a way to implement this in a simple way using apache POI API.

Let's create a small project (based on a previous project used in other posts) to persist and return student data. The data used will be very basic, being: registration number, name and grade.
Very simple so we don't lose focus.

The project was created in Java 21 with spring boot version 3.1.5

<b>Dependencies used:</b><br>
<b>Lombok</b> - to reduce boilerplate code<br>
<b>Mapstruct</b> - facilitates object mapping<br>
<b>OpenAi</b> - we will use a swagger so that you can run and use it without needing postman or another tool<br>
<b>POI API</b> - used to manipulate office documents like DOC, CSV, XLS<br>

