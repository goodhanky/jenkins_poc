job('NodeJS example') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git') {
            node ->
            node / gitConfigName('dsl_user')
            node / gitConfigEmail('jenkins-dsl@udemy.com')
        }
    }

    triggers {
        scm('H/5 * * * *')
    }

    wrappers {
        nodejs('nodejs')
    }

    steps {
        shell("npm install")
    }
}