const express = require('express');
const session = require('express-session');
const bodyParser = require('body-parser');
const app = express();

app.use(session({
    secret: 'super-secret-key-for-signing-the-cookie-id',
    saveUninitialized: true,
    resave: true
}));
// This is used for POST using json encoded body
app.use(bodyParser.json());
// This is used for POST from basic HTML forms <form><input stuff></input></form>
app.use(bodyParser.urlencoded({extended: true}));

app.get('/', (req, res) => {
    if (req.session.username) {
        return res.redirect('/admin');
    }
    res.send('<form action="/login" method="POST">\n' +
            '    <input type="text" placeholder="username" name="username"><br/>\n' +
            '    <input type="password" placeholder="password" name="password"><br/>\n' +
            '    <input type="submit" value="Submit" id="submit">\n' +
            '</form>');
});

app.post('/login', (req, res) => {
    console.log(req.body.username + " " + req.body.password)
    if (req.body.username === "admin" && req.body.password === "password") {
        req.session.username = req.body.username;
        res.redirect('/admin');
    } else {
        res.send('Wrong username or password, try again? (<a href="/">Login</a>)');
    }
});

app.get('/admin', (req, res) => {
    if (req.session.username) {
        res.send(`Hello ${req.session.username} (<a href="/logout">Logout</a>)`);
    } else {
        res.send('Please login first (<a href="/">Login</a>)');
    }
});

app.get('/logout', (req, res) => {
    req.session.destroy(() => {
        res.redirect('/');
    });
});

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});