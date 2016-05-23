package com.tacademy.ecommerce.common;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import lombok.Setter;

import org.springframework.data.domain.Page;

public class PaginationTag extends TagSupport {

  private static final long serialVersionUID = -245796494539272403L;

  private static final int PAGE_GROUP_SIZE = 10;

  @Setter
  private Page<?> page;

  public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      if (page.getTotalElements() > 0) {
        out.print(getPaginationStr());
      } else {
        out.print("<input type='hidden' id='page' name='page' value='1'/>");
      }
      this.release();
    } catch (java.io.IOException ex) {
      throw new JspException("Error in Paginator tag", ex);
    }

    return super.doStartTag();
  }

  private String getPaginationStr() {
    StringBuilder sb = new StringBuilder();
    int totalPages = page.getTotalPages();
    int startIndex = 0;
    int endIndex = startIndex;
    int currentPage = page.getNumber() + 1;

    if (totalPages > PAGE_GROUP_SIZE) {
      startIndex = currentPage - (PAGE_GROUP_SIZE / 2);
      endIndex = currentPage + (PAGE_GROUP_SIZE / 2);

      if (startIndex <= 0) {
        startIndex = 1;
        endIndex = startIndex + PAGE_GROUP_SIZE - 1;
      }

      if (endIndex > totalPages) {
        endIndex = totalPages;
        startIndex = totalPages - PAGE_GROUP_SIZE;
      }
    } else {
      startIndex = 1;
      endIndex = totalPages;
    }

    String firstButton = "";
    String prevButton = "";
    String nextButton = "";
    String lastButton = "";

    // first
    if (currentPage == 1) {
      firstButton = "<li class=\"paginate_button disabled\"><a href=\"#\">&lt;&lt;</a></li>";
    } else {
      firstButton = "<li class=\"paginate_button\"><a href=\"javascript:paginationTag.goPage(0)\">&lt;&lt;</a></li>";
    }

    // prev
    if (currentPage <= PAGE_GROUP_SIZE || startIndex <= PAGE_GROUP_SIZE) {
      prevButton = "<li class=\"paginate_button disabled\"><a href=\"#\">&lt;</a></li>";
    } else {
      prevButton = "<li class=\"paginate_button\"><a href=\"javascript:paginationTag.goPage(%d)\">&lt;</a></li>";
      prevButton = String.format(prevButton, startIndex - PAGE_GROUP_SIZE);
    }

    // next
    if (endIndex + PAGE_GROUP_SIZE < totalPages) {
      nextButton = "<li class=\"paginate_button\"><a href=\"javascript:paginationTag.goPage(%d)\">&gt;</a></li>";
      nextButton = String.format(nextButton, endIndex + PAGE_GROUP_SIZE);
    } else {
      nextButton = "<li class=\"paginate_button disabled\"><a href=\"#\">&gt;</a></li>";
    }

    // last
    if (currentPage == totalPages) {
      lastButton = "<li class=\"paginate_button disabled\"><a href=\"#\">&gt;&gt;</a></li>";
    } else {
      lastButton = "<li class=\"paginate_button\"><a href=\"javascript:paginationTag.goPage(%d)\">&gt;&gt;</a></li>";
      lastButton = String.format(lastButton, totalPages - 1);
    }

    sb.append("<ul class=\"pagination\">").append(firstButton).append(prevButton);

    // page group
    for (int i = startIndex; i <= endIndex; i++) {
      if (i == currentPage) {
        sb.append("<li class=\"paginate_button active\"><a href=\"#\">").append(i).append("</a></li>");
      } else {
        sb.append("<li class=\"paginate_button\"><a href=\"javascript:paginationTag.goPage(").append(i - 1).append(")\">")
            .append(i).append("</a></li>");
      }
    }

    sb.append(nextButton).append(lastButton).append(getPaginationScript());

    return sb.toString();
  }

  private String getPaginationScript() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!-- JAVASCRIPT START -->\n");
    sb.append("<script>\n");
    sb.append("var paginationTag = {\n");
    sb.append("  'goPage':function(cpage) {\n");
    sb.append("    var url = document.location.href.split('?');\n");
    sb.append("    var params = ''; ");
    sb.append("    if(url[1] == null){ params = 'page=1'; }else if(url[1].indexOf('page=') == -1 ){ params = url[1]+'&page=1'; }else { ");
    sb.append("    params = url[1]; }");
    sb.append("    document.location.href= url[0] + '?' + params.replace(/page=[\\d]{1,}/,'page=' + cpage);");
    sb.append("  }\n");
    sb.append("}\n");
    sb.append("</script>\n");
    sb.append("<!-- JAVASCRIPT End -->\n");

    return sb.toString();
  }

  /**
   * Release acquired resources to enable tag reuse.
   *
   * @see javax.servlet.jsp.tagext.Tag#release()
   */
  public void release() {
    super.release();
    this.page = null;
  }
}
