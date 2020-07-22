var express = require('express')
var session = require('express-session')
var parseurl = require('parseurl')
var app = express()

app.use(session({
    secret: 'super-secret-key-for-signing-the-cookie-id',
    resave: false,
    saveUninitialized: false
}))

app.use(function (req, res, next) {
    // TODO déclarer / incrémenter les compteurs
    next()
})

// TODO écrire les routes pour "page1" et "page2"

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});