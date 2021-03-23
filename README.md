# Spring Boot TODO List application

## Endpoints

### web
- /: Displays the index.html.
- /create: Displays the form to create an item.
- /save: Saves to the DB the Post request from the /create end point. Displays a summary of the new record.
- /completed: Displays all the completed items.
- /todo: Displays all ToDo items.
- /sorted: Displays all items and sorts them alphabetically by the description field.
- /shuffled: Displays all items in shuffled order.
- /mark/complete/item/{id}: Processes marking an item as complete and redirects back to /view/item/{id}.
- /mark/todo/item/{id}: Processes marking an item as todo and redirects back to /view/item/{id}.
- /delete/item/{id}: Processes deleting the item and redirect back to /
- /view/item/{id}: Displays item-detail.html with the details of the selected item.

#### TODO in web (/)
- edit/item/{id}: Should display a form prepopulated with a record's fields.
> Note that all Mappings have been created in the ItemController class.

### api (/api)
- Check out the api endpoints by checking the code in the following link: https://github.com/alvarobolanos/advjava_final_gui/blob/master/src/main/java/io/abolanos/item/ItemRestController.java

## Observations
I included some business logic in the controller that I should have taken care off in the service. I guess that while it's doable it's not a good practice. Specifically the itemDetail() and editItem() methods.

## Additional Resources:
- https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x
- https://stackoverflow.com/questions/41791802/autoincrement-id-postgresql-and-spring-boot-data-jpa
- https://www.baeldung.com/hibernate-identifiers
- https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
- https://www.postman.com/
- https://www.baeldung.com/spring-boot-h2-database
- https://www.kindsonthegenius.com/2019/11/28/devops-ci-cd-pipeline-step-by-step-tutorial-springboot-github-heroku/
- https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data
