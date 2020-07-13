package com.prography.playeasy.api;

import android.util.Log;

import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.models.Match;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatchDaoUnitTest extends BaseDaoUnitTest {

    @Test
    public void createMatchTest() {
        Date date = new Date();
        MatchDto matchData = new MatchDto("FOOTSAL6", "축구뜨자", date, 120, 3000, "010-9165-6918", 6);
        LocationDto locationData = new LocationDto(3.14f, 7.77f, "마루 180", "강남구", "마루 경기장");
        MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto(matchData, locationData);
        new MatchDao(FAKE_TOKEN).create(matchPostRequestDto, new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                assertEquals(null, response.body());
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Test
    public void retrieveTest() {
        new MatchDao(FAKE_TOKEN).retrieve(new Date(), new Callback<List<MatchDto>>() {
            @Override
            public void onResponse(Call<List<MatchDto>> call, Response<List<MatchDto>> response) {
                List<MatchDto> compareList = new ArrayList<MatchDto>(5);
                assertArrayEquals(response.body().toArray(), compareList.toArray());
            }

            @Override
            public void onFailure(Call<List<MatchDto>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Test
    public void getMatchTest() {
        new MatchDao(FAKE_TOKEN).findById(1, new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                assertEquals(null, response.body());
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

}
