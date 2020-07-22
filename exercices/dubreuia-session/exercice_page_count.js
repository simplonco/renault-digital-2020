var express = require('express')
var session = require('express-session')
var app = express()

app.use(session({
    secret: 'super-secret-key-for-signing-the-cookie-id',
    resave: false,
    saveUninitialized: false
}))

app.use(function (req, res, next) {
    // Ce "middleware" est appelé avant TOUTE requête,
    // ce qui permet de faire des opérations d'initialisation
    // et d'incrémentation...
    if (!req.session.count) {
        // TODO utiliser req.session.count pour initialiser un compteur
    }
    // TODO incrementer le compteur
    next()
})

app.get('/', function (req, res) {
    // TODO imprimer "vous avez vu cette page x fois" avec x etant le compteur
})

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});
