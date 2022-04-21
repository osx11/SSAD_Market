## Market emulation

The program is designed to simulate a market. Users can register and review products, whereas an
admin is able to create products, see fake reviews and delete them. When user submits
their review for a product, the following algorithm is executed: firstly, the system will check
if the user submitted reviews earlier. If no, then the review will be accepted without any checks.
However, if user have already done this earlier, the system will take the very first review
of the product and compare it with the current one. If the similarity is more than or equal to
70%, then such a review will be marked as fake. It will be accepted anyway, but the admin will
see that this review is fake, and it will be available for deleting. You can read more about
the internal structure of the program in our report: Also,
[UML class diagram](https://drive.google.com/file/d/160g4VCyP59wjs47gMEL-HF1XOEJoZMDB/view?usp=sharing) is attached.

### Usage:

To start the program, double-click on Market.jar file or run the command:

`java -jar Market.jar`

The list of available commands:
```
- EXIT (Usage: EXIT)
- REGISTER (Usage: LOGIN [username] [name] [surname] [password])
- LOGIN (Usage: LOGIN [username] [password])
- LOGOUT (LOGOUT)
- ADDPRODUCT (Usage: ADDPRODUCT [product name])
- PRODUCTS (Usage: PRODUCTS)
- REVIEW (Usage: REVIEW [product ID] [your_review])
- SHOWFAKE (Usage: SHOWFAKE)
- SHOWREVIEWS (Usage: SHOWREVIEWS [product ID])
- DELETEFAKE (Usage: DELETEFAKE)
```

Default credentials:
```
Username: user
Password: 123123
Authorized: false

Username: admin
Password: qwerty
Authorized: true
```
