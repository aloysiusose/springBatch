# springBatch
This program utilizes spring batch for data processing.
Data is ingested by spring batch, processed and persisted in a data base for foyrther uses.
Spring Batch uses a job launcher to carry out a batch job which consist of one or more steps and stores its meta data in a job repository.
Each individual step in the job consists of a reader to reader the data, a processor to process the data and a writer to store it into a data base.
Spring batch can handle a large amount of data which can be processed in chuncks for consistency.

For this project, the Top 100 movies on Nextflix was ingested from a csv file gotten from Kaggle and persited into a data base
The main aim was to explore the spring batch module of the spring framework.
