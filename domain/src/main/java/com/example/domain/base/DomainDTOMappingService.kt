package com.example.domain.base


interface DomainDTOMappingService<Domain,DTO> {

    fun mapDomainToDTO(domain : Domain) : DTO

     fun mapDomainToDTO(domainlist : List<Domain>) : List<DTO> = domainlist.map { domain->
        mapDomainToDTO(domain)
    }
}