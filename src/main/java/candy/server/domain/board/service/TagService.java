package candy.server.domain.board.service;

import candy.server.domain.board.dao.JpaTagRepository;
import candy.server.domain.board.dto.TagCreateRequestDto;
import candy.server.domain.board.entity.CaTagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TagService {
    private final JpaTagRepository tagRepository;

    public boolean createTag(TagCreateRequestDto dto) {
        Optional<CaTagEntity> tagOld = tagRepository.findByTagName(dto.getTagName());

        if (tagOld.isPresent())
            return false;

        CaTagEntity tag = CaTagEntity.builder()
                .tagName(dto.getTagName())
                .build();

        tagRepository.save(tag);
        return true;
    }
}
