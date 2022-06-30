package candy.server.domain.board.service;

import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.article.util.ArticleUtils;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.board.dto.BoardPaginationResponseDto;
import candy.server.domain.board.entity.CaBoardEntity;
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

    public BoardPaginationResponseDto articles(String id, int p) {
        Optional<CaBoardEntity> board = boardRepository.findByBoardKey(id);
        if (board.isEmpty())
            return  null;

        Page<CaArticleEntity> articles = articleRepository.findByBoardId(board.get(), PageRequest.of(p, 10));

        List<BoardPaginationResponseDto.PaginationItem> items = articles.stream().map(article ->
                BoardPaginationResponseDto.PaginationItem.builder()
                        .id(article.getArticleId())
                        .title(article.getArticleTitlePretty())
                        .tags(article.getArticleTags() != null ? article.getArticleTags().split(",") : null)
                        .summary(article.getArticleBody())
                        .author(ArticleUtils.getAuthor(article))
                        .up(article.getArticleUpvote())
                        .down(article.getArticleDownvote())
                        .view(article.getArticleView())
                        .build()
        ).collect(Collectors.toList());

        return BoardPaginationResponseDto.builder()
                .articles(items)
                .build();
    }
}
