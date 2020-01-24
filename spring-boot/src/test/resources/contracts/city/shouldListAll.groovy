import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return all available cities"
    request{
        method GET()
        url("/cities/")
    }
    response {
        status 200
        body(
                _embedded : [
                    cityResources : [
                        [
                            id: 1,
                            name : 'Prague',
                            country : 'Czech Republic'
                        ]
                    ]
                ]
        )
    }
}