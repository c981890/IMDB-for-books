# IMDB-for-books

- Clone to computer
- use your favourite IDEA and import project from existing resources
- run the ImdbforbooksApplication

Program starts H2 database in mem mode and imports csv files.
I have replaced full csv's with csv's containing 10 000 entries. Despite this
it would be OK to get a cup of coffee while waiting. 

TODO
- Criteria based queries
    - SELECT
    - AVG(bookrating),
    - ISBN
    - FROM ratings
    - GROUP BY ISBN
    - ORDER BY 1 DESC
    - LIMIT 10;
- @OneToMany relationships
- log4j logging
