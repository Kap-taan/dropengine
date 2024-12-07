# Notes App

## Note table

- id (Long)
- title (String)
- description (String)
- author (String) [also the admin] [Only one writer] [Mapping]
- list of readers [Mapping]
- list of editors [Mapping]
- status [public or private]
- likes
- created_at (Date)

## Request table

- id (Long)
- blogId (Long) [Mapping]
- userId (Long) [Mapping]
- status
- created_at (Date)

## User

- id (Long)
- name (String)
- username (String)
- avatar (String)
