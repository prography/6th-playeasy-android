package com.prography.playeasy.match.domain;

import android.annotation.SuppressLint;
import android.util.Log;

import com.prography.playeasy.lib.RetrofitClientFactory;

import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchUpdateRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.models.Match;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Match 에 대한 API에 접근하는 객체(보통은 DB에 접근할 때 쓰기 때문에, DAO가 올바른 표현은 아닐 수 있음.)
 * 웹 프로젝트에서는 ApiClient라는 이름으로 쓰기도 하지만, 이 DAO는 Match 관련된 데이터만 접근 할 것이므로 MatchDao로 명명함.
 //file 하나는 목적이 하나

 */
public class MatchDao {

    private RetrofitMatchApi matchClient;
    private String token;

    public MatchDao(String token) {
        this.matchClient = RetrofitClientFactory.getClient(RetrofitMatchApi.class);
        this.token = token;
    }

    public void create(MatchPostRequestDto requestDto, Callback<MatchDetailDto> callback) {
        Call<MatchDetailDto> call = matchClient.postMatch(token, requestDto);
        call.enqueue(callback);
    }

    public void retrieve(Date date, Callback<List<MatchDto>> callback) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Call<List<MatchDto>> call = matchClient.getMatchList(formatter.format(date));
        call.enqueue(callback);
    }

    public void findById(int matchId, Callback<MatchDetailDto> callback) {
        Call<MatchDetailDto> call = matchClient.getMatch(matchId);
        call.enqueue(callback);
    }

    public void reviseMatch(MatchUpdateRequestDto matchReviseDto, Callback<MatchDetailDto> callback) {
        Call <MatchDetailDto> call=matchClient.reviseMatch(token,matchReviseDto);
        call.enqueue(callback);
    }

    public void closeMatch(int matchId, Callback<MatchDetailDto> callback) {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("matchId", matchId);
        hashMap.put("status", "CANCEL");
        Call<MatchDetailDto> call = matchClient.closeMatch(hashMap);
        call.enqueue(callback);
          //  String nestedJson="{"matchId"+":"+matchId+","+"statusType" +":"+ status+"}
//            JSONObject json = new JSONObject();
//            json.put("matchId", matchId);
//            json.put("status","CANCEL");
          //  String json = "{\"matchId\":"+matchId+",\"status\":\"CANCEL\"}";
           // TypedInput in = new TypedByteArray("application/json", json.getBytes("UTF-8"));

            matchClient.closeMatch(hashMap);

//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);
    }
}