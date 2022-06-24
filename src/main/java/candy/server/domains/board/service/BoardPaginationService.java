package candy.server.domains.board.service;

import candy.server.domains.article.dao.JpaArticleRepository;
import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.article.util.ArticleUtils;
import candy.server.domains.board.dao.JpaBoardRepository;
import candy.server.domains.board.dto.BoardPaginationDto;
import candy.server.domains.board.entity.CaBoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardPaginationService {
    private final JpaBoardRepository boardRepository;
    private final JpaArticleRepository articleRepository;

    public BoardPaginationDto.BoardPaginationResponse articles(String id, int p) {
        Optional<CaBoardEntity> board = boardRepository.findByBoardKey(id);
        if (board.isEmpty())
            return  null;

        Page<CaArticleEntity> articles = articleRepository.findByBoardId(board.get(), PageRequest.of(p, 10));

        List<BoardPaginationDto.BoardPaginationResponse.PaginationItem> items = articles.stream().map(article ->
                BoardPaginationDto.BoardPaginationResponse.PaginationItem.builder()
                        .id(article.getArticleId())
                        .title(article.getArticleTitlePretty())
                        .summary(article.getArticleBody())
                        .author(ArticleUtils.getAuthor(article))
                        .up(article.getArticleUpvote())
                        .down(article.getArticleDownvote())
                        .view(article.getArticleView())
                        .build()
        ).collect(Collectors.toList());

        return BoardPaginationDto.BoardPaginationResponse.builder()
                .articles(items)
                .build();
    }
}
