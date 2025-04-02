# Library Kata

# Usage

Get all users

    curl --location 'http://localhost:8080/users/all'

Get all books

    curl --location 'http://localhost:8080/books/all'

Add a new book to the catalog

    curl --location 'http://localhost:8080/books' \
    --header 'Content-Type: application/json' \
    --data '{
        "name": "Airborne2",
        "borrowedBy": null
    }'

A user can borrow a book

    curl --location 'http://localhost:8080/books/3/user/1/borrow'

A user can return a book

    curl --location 'http://localhost:8080/books/3/user/1/return'

Print a list of the books that I borrowed

    curl --location 'http://localhost:8080/books/user/1/borrowed'