package org.alongtheblue.alongtheblue_server.domain.userInfo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.alongtheblue.alongtheblue_server.domain.courseLike.domain.CourseLike;
import org.alongtheblue.alongtheblue_server.domain.itemLike.domain.ItemLike;
import org.alongtheblue.alongtheblue_server.domain.search.domain.Search;
import org.alongtheblue.alongtheblue_server.domain.tourCourse.domain.TourCourse;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String uid;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Search> searches = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemLike> itemLikes = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TourCourse> tourCourses = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CourseLike> courseLikes = new ArrayList<>();



    @Builder
    public UserInfo(String userName, String uid) {
        this.userName = userName;
        this.uid = uid;
    }
}