var express = require('express')
var session = require('express-session')
var FileStore = require('session-file-store')(session);
var app = express()

app.use(session({
    secret: 'super-secret-key-for-signing-the-cookie-id',
    resave: false,
    saveUninitialized: false,
    store: new FileStore({})
}))

app.use(function (req, res, next) {
    if (!req.session.count) {
        req.session.count = 0
    }
    req.session.count += 1
    next()
})

app.get('/', function (req, res) {
    res.send('you viewed this page ' + req.session.count + ' times')
})

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});
