package com.ssm.movie.web;

import com.ssm.movie.bean.MovieMessage;
import com.ssm.movie.bean.MovieReview;
import com.ssm.movie.bean.ResultInfo;
import com.ssm.movie.service.IMovieReviewService;
import com.ssm.movie.service.IMovieSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/single")
public class SingleController {

    @Autowired
    private ResultInfo resultInfo;

    @Autowired
    private IMovieSingleService movieSingleService;

    @Autowired
    private MovieReview movieReview;

    @Autowired
    private IMovieReviewService movieReviewService;

    /**
     * 电影信息展示
     * @param src
     * @return
     */
    @RequestMapping("/detailInformation")
    public @ResponseBody ResultInfo showMovieMessage(@RequestBody String src) {
        String[] split = src.split("D");
        try {
            List<MovieMessage> movieMessageList = movieSingleService.findBySrc(split[1]);
            System.out.println(movieMessageList);
            resultInfo.setFlag(true);
            movieMessageList.get(0);
            resultInfo.setData(movieMessageList.get(0));
            return resultInfo;
        } catch (Exception e) {
            //e.printStackTrace();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("未知错误请联系管理员！");
            return resultInfo;
        }

    }

    @RequestMapping("/saveMovieReview")
    public @ResponseBody ResultInfo movieReview(String src, String code, String name, String review) {
        System.out.println(src);
        System.out.println(code);
        System.out.println(name);
        System.out.println(review);
        try {
            movieReview.setMovieSrc(src);
            movieReview.setReview(review);
            movieReview.setReviewTime(new Date());
            movieReview.setStatus("Y");
            movieReview.setUserCode(code);
            movieReview.setUserName(name);
            movieReviewService.saveMovieReview(movieReview);
            resultInfo.setFlag(true);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("评论失败！");
            return resultInfo;
        }
    }

    @RequestMapping("/reviewInformation")
    public @ResponseBody ResultInfo reviewInformation() {
        try {
            resultInfo.setData(movieReviewService.selectMessage());
            System.out.println(movieReviewService.selectMessage());
            resultInfo.setFlag(true);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("服务器出错啦，请刷新重试！");
            return resultInfo;
        }
    }

}
