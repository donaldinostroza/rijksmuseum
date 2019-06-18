# Rijksmuseum app

## What the app does:
- It retrieve a list of art objects from Rijksmuseum museum and shows them to the user.

## What's missing and future work
- Move the api key outside the app (i.e. to a middleware).
- Move the logic from activity to presenter.
- Load images with a tool like Picasso.
- Implement a search tool to find art objects by maker's name.
- Create a contract between View and Presenter.
- Include tests.

## About the architecture
The idea is to follow an MVP architecture.
Retrofit is used for networking connections.
