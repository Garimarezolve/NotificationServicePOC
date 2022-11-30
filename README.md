# NotificationServicePOC

Features
   RabbitMQ
    MongoDb
    Lombok
    Java 11

Requirements
  git
  jdk11
  
  
Steps to start the application
1.Run the microservice_a (Message producer) it will produce 1,00,000 message in RabbitMq  within 3 seconds
2.Run the microservice_b (Message Consumer) it will consume 1,00,000 messgae in RabbiMq within 3 seconds and it will save the records in the Mongodb collection.
3.Once it consumes message and it will check for duplicate emails if its there it will not create duplicate entries and then it will send email 
4.for whats app service need to optin the contact  on Gupshup Service provider then  our applicaion will be able to send the whats app messgaes

