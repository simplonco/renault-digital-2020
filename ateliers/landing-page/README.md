# Création d'une landing page pour chef d'oeuvre

## Installation et pré-requis

- Installer `npm` et `node` : [Node.js](https://nodejs.org/en/download/)
- Framework front:
    - Si Angular, installer `ng` : `npm install -g @angular/cli`
    - Si React, rien à faire
- Un nouveau dépôt privé sur GitHub
    - Example Simplon.co : https://github.com/simplonco/renault-digital-2020-chef-doeuvre
    - `git clone git@github.com:simplonco/renault-digital-2020-chef-doeuvre.git`
    - `renault-digital-2020-chef-doeuvre`

## Création de votre application front

Dans un terminal :

| Angular | React |
| --- | --- |
| `ng new client` | `npx create-react-app client` |

Cela devrait créer votre application front dans le dossier "client". Ensuite `cd client`.

Pour votre application sur http://127.0.0.1:3000 :

```bash
npm start
```

## Ajout de [Bootstrap](https://getbootstrap.com/docs/4.0/getting-started/introduction/)

Ajouter Bootstrap dans le `head` :

| Angular | React |
| --- | --- |
| "src/index.html" | "public/index.html" |

```html
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous"/>
```

## Ajout d'une [navigation](https://getbootstrap.com/docs/4.0/components/navbar/)

Ajouter une navigation à la racine de votre app :

| Angular | React |
| --- | --- |
| "src/app/app.component.html" | "src/App.js" |

```html
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
</nav>
```

## Ajout de structure [grid layout](https://getbootstrap.com/docs/4.0/components/card/#using-grid-markup)

Ajouter une structure en mode grid layout :

| Angular | React |
| --- | --- |
| "src/app/app.component.html" | "src/App.js" |

```html
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
</div>
```

## Ajouter du contenu

Pour l'instant, le contenu n'est pas primordial, on cherche à créer un squelette d'application. Vous pouvez utiliser du contenu provisoire avec :

- Images - Flickr a une section "creative commons" (images en "open source") : https://www.flickr.com/search/?text=cat&license=2%2C3%2C4%2C5%2C6%2C9
- Texte - Le plus simple pour générer du texte : https://loremipsum.io/generator/
