# lein-ragtime-gen

- one of leiningen plugins
- generating ragtime migration files

## Usage

```
[lein-ragtime-gen "0.0.1"]
```

You need ...
- [ragtime "0.5.0"] or later


#### You need to make a migration path.

e.g.
```
mkdir project-root/resources/migrations
```

#### project.clj

```
(defproject project "1.0.0"
  :dependencies [[ragtime "0.5.0"]]
  ...
  :plugins [[lein-ragtime-gen "0.0.1"]]
  ...
  :migration-path "/migrations")
```

#### lein ragtime-gen 'migration-name'

e.g.
```
$ lein ragtime-gen create-users
$ lein ragtime-gen alter-users-add-name
```

## License

Copyright © 2015 kwakbab

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
