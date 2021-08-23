rootProject.name = "gradle-multi-project-support-sample"

// api doc
include("api-doc")
include("api-doc:model-java")

// kotlin version
include("coffee:api:server")
include("coffee:api:client")

include("juice:api:server")
include("juice:api:client")

include("shop:server")

// java version
include("coffee-java:api:server")
include("coffee-java:api:client")

include("juice-java:api:server")
include("juice-java:api:client")

include("shop-java:server")
