// package com.deloitte.utils;
//
// public class Just {
//
// // @RunWith(MockitoaJunitRunner.Silent.class)
//
// // @Mapper(componentModel = "spring", uses=BaseMapper.class)
// // @Mappings({
// // @Mapping(target = "",source="",ignore ="",expression="java(null"),....
// //
// // })
//
// // @DecoratedWith(anydecorator.class)
//
// // model implements java.io.Serialozable
//
// // anyDecortaor implements mappper, @autowried,@qualifier(delegate)name as
// // delegate;
// // use delegate.same metodname at first line
//
// // com.fasterxml.jackson.core, org.mapstruct.mapstruct, mapstruct-processor,
//
// //
// list.stream.flatmap(b->CollectionUtils.emptyIfNull(b.getList).stream()).map(h->h.getid.getiff).collect(Collectors.toList());
// // string date= new SimpleDateFormat(timeformat).format()timestamp();
// // Stream.of(enums).collet to list
// // api,enums,utiity
// // classes,exception,model.dto,MODEL.ENTITY,model.mapper,repository or dao
// // and daoimpl with
// // getsession by sessionfactoory.get(),service => calls dao or repo get
// // entity, call mapper to map to dto
//
// // jpabuilder,criteriabuilder
//
// // dto have @JsonInclude(JsonInclude.Include.NON_EMPTY), @JsonIgnore for
// // fields,@JsonProperty("")
// // @PrepareForTest({Decorator}),powermock
// }
//
// package com.deloitte.mapper;
//
// import org.mapstruct.InjectionStrategy;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.MappingConstants;
// import org.mapstruct.Mappings;
//
// import com.deloitte.dto.ServiceDto;
// import com.deloitte.model.Service;
//
// @Mapper(componentModel = MappingConstants.ComponentModel.CDI,
// injectionStrategy = InjectionStrategy.CONSTRUCTOR)
// public interface ServiceDetailMapper {
//
// @Mappings({@Mapping(target = "id", source = "id"),
// @Mapping(target = "serviceName", source = "serviceName"),
// @Mapping(target = "serviceDetailId", source = "serviceDetailId")})
// public ServiceDto mapToServiceDto(Service service);
//
// }
//
// annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.2.Final'
// testAnnotationProcessor 'org.mapstruct:mapstruct-processor:1.5.2.Final'
// // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
// implementation group: 'org.mapstruct', name: 'mapstruct', version:
// '1.5.2.Final'
// compileJava {
// options.compilerArgs += [
// '-Amapstruct.suppressGeneratorTimestamp=true',
// '-Amapstruct.suppressGeneratorVersionInfoComment=true',
// '-Amapstruct.verbose=true'
// ]
// }

//@Component
//public class UserDetailMapper {
//
//	public UserDto mapToUserDto(UserDetail userDetail) {
//		return new UserDto(userDetail.getFirstName(), userDetail.getLastName(), userDetail.getEmail(),
//				userDetail.getPassword(), userDetail.getContact(), userDetail.getGender(), userDetail.getDob());
//	}
//}

//<app-header></app-header>
//<!-- <div class="tile is-ancestor">
//  <div class="tile is-vertical is-8">
//    <div class="tile">
//      <div class="tile is-parent is-vertical">
//        <article class="tile is-child notification is-primary">
//          <p class="title">Vertical...</p>
//          <p class="subtitle">Top tile</p>
//        </article>
//        <article class="tile is-child notification is-warning">
//          <p class="title">...tiles</p>
//          <p class="subtitle">Bottom tile</p>
//        </article>
//      </div>
//      <div class="tile is-parent">
//        <article class="tile is-child notification is-info">
//          <p class="title">Middle tile</p>
//          <p class="subtitle">With an image</p>
//          <figure class="image is-4by3">
//            <img src="../assets/img/2202_w020_n001_1278b_p15_1278.jpg" />
//          </figure>
//        </article>
//      </div>
//    </div>
//    <div class="tile is-parent">
//      <article class="tile is-child notification is-danger">
//        <p class="title">Wide tile</p>
//        <p class="subtitle">Aligned with the right tile</p>
//        <div class="content">
//       // Content 
//        </div>
//      </article>
//    </div>
//  </div>
//</div> -->
//<div class="tile is-ancestor contain">
//  <article class="tile is-child notification is-info">
//    <figure class="image is-360x240">
//      <img
//        src="https://content.jdmagicbox.com/comp/bhilai/i5/9999px788.x788.171115115006.a2i5/catalogue/service-on-doorstep-bhilai-ac-repair-and-services-12njq5wprd.jpg"
//      />
//    </figure>
//  </article>
//</div>
//<router-outlet></router-outlet>
//<app-footer></app-footer>
//<!-- <div class="tile is-ancestor">
//  <figure class="image is-360x240">
//    <img src="../assets/img/2202_w020_n001_1278b_p15_1278.jpg" />
//  </figure>
//</div> -->
//<!-- https://harpreetford.com/assets/admin/images/WhatsApp%20Image%202020-01-06%20at%203.06.50%20PM.jpeg" -->
