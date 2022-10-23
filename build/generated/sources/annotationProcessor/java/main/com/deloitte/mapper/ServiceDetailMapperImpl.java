package com.deloitte.mapper;

import com.deloitte.dto.ServiceDto;
import com.deloitte.model.Service;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T19:57:45+0530",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class ServiceDetailMapperImpl implements ServiceDetailMapper {

    @Override
    public ServiceDto mapToServiceDto(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceDto serviceDto = new ServiceDto();

        serviceDto.setId( service.getId() );
        serviceDto.setServiceName( service.getServiceName() );
        serviceDto.setServiceDetailId( service.getServiceDetailId() );

        return serviceDto;
    }
}
