job('NodeJS Docker example') {
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
        nodejs('nodejs_7.10.0')
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('goodhanky/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}