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
    res.send('<form action="/login" method="POST">\n' +
            '    <input type="text" placeholder="username" name="username"><br/>\n' +
            '    <input type="password" placeholder="password" name="password"><br/>\n' +
            '    <input type="submit" value="Submit" id="submit">\n' +
            '</form>');
});

app.post('/login', (req, res) => {
    // TODO verifier le login
});

app.get('/admin', (req, res) => {
    // TODO afficher du contenu sur l'utilisateur loggué
});

app.get('/logout', (req, res) => {
    // TODO supprimer la session de l'utilisateur
});

app.listen(3000, () => {
    console.log(`App started on: http://127.0.0.1:3000`);
});