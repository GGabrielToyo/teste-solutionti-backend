package com.teste.solution.address.domain;

import com.teste.solution.address.domain.dtos.CreateAddressDto;
import com.teste.solution.address.domain.dtos.UpdateAddressDto;
import com.teste.solution.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "tb_solti_address")
@Entity(name = "Address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solti_address_id")
    private UUID id;

    @Column(name = "solti_address_zip_code", length = 20, nullable = false)
    private String zipCode;

    @Column(name = "solti_address_street", length = 255)
    private String street;

    @Column(name = "solti_address_complement", length = 255)
    private String complement;

    @Column(name = "solti_address_unit", length = 50)
    private String unit;

    @Column(name = "solti_address_district", length = 100)
    private String district;

    @Column(name = "solti_address_city", length = 100)
    private String city;

    @Column(name = "solti_address_state_abbr", length = 5)
    private String stateAbbr;

    @Column(name = "solti_address_region", length = 50)
    private String region;

    @Column(name = "solti_address_ibge_code", length = 10)
    private String ibgeCode;

    @Column(name = "solti_address_gia_code", length = 10)
    private String giaCode;

    @Column(name = "solti_address_area_code", length = 3)
    private String areaCode;

    @Column(name = "solti_address_siafi_code", length = 10)
    private String siafiCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solti_address_user_id", nullable = false)
    private User user;

    public Address(CreateAddressDto createAddressDto, User user) {
        this.zipCode = createAddressDto.zipCode();
        this.street = createAddressDto.street();
        this.complement = createAddressDto.complement();
        this.unit = createAddressDto.unit();
        this.district = createAddressDto.district();
        this.city = createAddressDto.city();
        this.stateAbbr = createAddressDto.stateAbbr();
        this.region = createAddressDto.region();
        this.ibgeCode = createAddressDto.ibgeCode();
        this.giaCode = createAddressDto.giaCode();
        this.areaCode = createAddressDto.areaCode();
        this.siafiCode = createAddressDto.siafiCode();
        this.user = user;
    }

    public void update(UpdateAddressDto updateAddressDto) {
        this.zipCode = updateAddressDto.zipCode() != null ? updateAddressDto.zipCode() : this.zipCode;
        this.street = updateAddressDto.street() != null ? updateAddressDto.street() : this.street;
        this.complement = updateAddressDto.complement() != null ? updateAddressDto.complement() : this.complement;
        this.unit = updateAddressDto.unit() != null ? updateAddressDto.unit() : this.unit;
        this.district = updateAddressDto.district() != null ? updateAddressDto.district() : this.district;
        this.city = updateAddressDto.city() != null ? updateAddressDto.city() : this.city;
        this.stateAbbr = updateAddressDto.stateAbbr() != null ? updateAddressDto.stateAbbr() : this.stateAbbr;
        this.region = updateAddressDto.region() != null ? updateAddressDto.region() : this.region;
        this.ibgeCode = updateAddressDto.ibgeCode() != null ? updateAddressDto.ibgeCode() : this.ibgeCode;
        this.giaCode = updateAddressDto.giaCode() != null ? updateAddressDto.giaCode() : this.giaCode;
        this.areaCode = updateAddressDto.areaCode() != null ? updateAddressDto.areaCode() : this.areaCode;
        this.siafiCode = updateAddressDto.siafiCode() != null ? updateAddressDto.siafiCode() : this.siafiCode;
    }
}
