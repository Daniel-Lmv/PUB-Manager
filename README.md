# Gestor de Publicações
*Formato do JSON*

{
    
    "pubId": long,
    
    "user": String,
    
    "status": boolean,
    
    "publishedAt": java.time.Instant,
    
    "text": String,
    
    "summary": String
    
}

*Endpoints:*
| Endpoint | HTTP Method | Descrição |
| -------- | --------- | ---------- |
| pub-manager/v1/pubs | GET | Retorna todas as publicações |
| pub-manager/v1/pubs/pubId | GET | Retorna uma publicação a partir do id |
| pub-manager/v1/pubs | POST | Salva uma publicação (enviada no corpo da requisição) |
| pub-manager/v1/pubs | PUT | Atualiza uma publicação (enviada no corpo da requisição) |
| pub-manager/v1/pubs/pub_Id | DELETE | Deleta uma publicação |
