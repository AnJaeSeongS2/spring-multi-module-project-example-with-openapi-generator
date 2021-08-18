rootProject.name = "gradle-multi-project-support-sample"

include("coffee:protocol")
include("coffee:api:server")
include("coffee:api:client")

include("coffee-java:protocol")
include("coffee-java:api:server")
include("coffee-java:api:client")

include("juice:api:client")
include("juice:api:server")
include("juice:protocol")

include("shop:server")
include("shop-java:server")
