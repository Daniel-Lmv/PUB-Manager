# Gestor de Publicações
*Formato do JSON*

*Not Blank (não em branco)

{
    
    *"user": String,
    
    "text": String,
    
    *"summary": String
    
}

*Endpoints:*
| Endpoint | HTTP Method | Descrição |
| -------- | --------- | ---------- |
| pub-manager/v1/pubs | GET | Retorna todas as publicações |
| pub-manager/v1/pubs/{pubId} | GET | Retorna uma publicação a partir do pubId |
| pub-manager/v1/pubs/user/{user} | GET | Retorna todas as publicações de um mesmo user |
| pub-manager/v1/pubs | POST | Salva uma nova publicação (enviada no corpo da requisição). Retorna pubId |
| pub-manager/v1/pubs/{pub_Id} | PUT | Atualiza uma publicação (enviada no corpo da requisição) |
| pub-manager/v1/pubs/{pub_Id} | DELETE | Deleta uma publicação a partir do pubId |

