# Cvičení 03 - @Controller a @Service
### Popis projektu
* Projekt demonstruje využití: 
    * @Controller
    * @Service
    * @Scope 
    * @RequestMapping
    * @GetMapping
    * @PostMapping
    * @DeleteMapping
    * Jednoduchý formulář
    * Jednoduché získání dat

Projekt je zaměřen na "vytvoření uživatelů", jejich následné zobrazení, případně i mazání.

#####Úvodní stránka
![img.png](img.png)
* Obsahuje jednoduché menu
    * Testovací formulář: formulář pro přidání uživatele
    * Přidaní uživatelé: Všichni přidaní uživatelé
#####Formulář pro přidání uživatele
![img_1.png](img_1.png)
* Jednoduchý formulář pro přidání uživatele
* Po stisku submit se odešle POST request na form/send, kde se dále zpracuje
#####Stránka oznamující přidání uživatele
![img_2.png](img_2.png)
* Jednoduchý výpis toho, co jsme zapsali v předchozím formuláři
* A počet odeslání formuláře (to je realizováno pomocí FormService (Scope = session))
#####Stránka vypisující uživatele
![img_3.png](img_3.png)
* Jednoduchý výpis uživatelů

### Ukázkové requesty a response
* Vybrané requesty, které nejsou reprezentovány v prohlížeči
1. DELETE All
   
   Request: DELETE http://localhost:8080/user/deleteAll
   
Response:

    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Deleted user</title>
    </head>
    <body>
    <span>1 user/s was deleted</span>
    </body>
    </html>
    
    Response code: 200; Time: 37ms; Content length: 209 bytes

2. DELETE by ID

  Request: DELETE http://localhost:8080/user/delete?id=1

Response:

    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Deleted user</title>
    </head>
    <body>
    <span>1 user/s was deleted</span>
    </body>
    </html>
    
    Response code: 200; Time: 56ms; Content length: 209 bytes




  


