package at.ac.tuwien.dmap.dmapbackend.fits.dto.mapper;

public interface DTOMapper<T, F> {

    T fromDTO(F dto);
}
