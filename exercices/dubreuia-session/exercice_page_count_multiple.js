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
    if (!req.session.views) {
        req.session.views = {}
    }
    // get the url pathname
    var pathname = parseurl(req).pathname
    // count the views
    req.session.views[pathname] = (req.session.views[pathname] || 0) + 1
    next()
})

app.get('/page1', function (req, res) {
    res.send('you viewed this page ' + req.session.views['/page1'] + ' times')
})

app.get('/page2', function (req, res) {
    res.send('you viewed this page ' + req.session.views['/page2'] + ' times')
})

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});
