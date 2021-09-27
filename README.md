운영배포 후 약 80일간 서비스하여 일간 20만 정도의 PV를 기록했던 MBC Corona19 상황판은 2020년 4월 20일부로 **서비스 종료**되었음을 알려드립니다. 실제 작업한 Repository는 Private이며, 이 Repository는 운영했던 서비스를 아카이브하기 위한 용도의 Public repository입니다.

# MBC 코로나19 상황판
- 기획: MBC
- 개발: 서울대 멋쟁이사자처럼(3명)
- 개발기간: 2020년 2월 1일 ~ 2020년 2월 2일
- 운영기간: 2020년 2월 3일 ~ 2020년 4월 20일
- 관련 뉴스기사
  * Article  
  [MBC, '신종 코로나바이러스' 상황판 오픈 (2020년 2월 3일 기사)](https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=214&aid=0001011703)
  * Video  
  [![MBC corona open new](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/video_thumbnail.png)](https://www.youtube.com/watch?v=F5YKbLUHGUU)
- 서비스 구성
  1. [세계 요약 표 + 지도](https://github.com/HyunSangHan/MBC-corona19-archive#%EC%84%B8%EA%B3%84-%EC%9A%94%EC%95%BD-%ED%91%9C--%EC%A7%80%EB%8F%84)
  2. [국내 요약 표](https://github.com/HyunSangHan/MBC-corona19-archive#%EA%B5%AD%EB%82%B4-%EC%9A%94%EC%95%BD-%ED%91%9C)
  3. [국내 확진자 이동경로(카카오지도 표시)](https://github.com/HyunSangHan/MBC-corona19-archive#%EA%B5%AD%EB%82%B4-%ED%99%95%EC%A7%84%EC%9E%90-%EC%9D%B4%EB%8F%99%EA%B2%BD%EB%A1%9C)
  4. [국내 확진자 전파경로(Tree 그래프 형태)](https://github.com/HyunSangHan/MBC-corona19-archive#%EA%B5%AD%EB%82%B4-%ED%99%95%EC%A7%84%EC%9E%90-%EC%A0%84%ED%8C%8C%EA%B2%BD%EB%A1%9C)
  5. [휴업 현황](https://github.com/HyunSangHan/MBC-corona19-archive#%ED%9C%B4%EC%97%85%ED%8F%90%EC%87%84-%ED%98%84%ED%99%A9) 
  6. [선별진료소 현황](https://github.com/HyunSangHan/MBC-corona19-archive#%EC%84%A0%EB%B3%84%EC%A7%84%EB%A3%8C%EC%86%8C-%ED%98%84%ED%99%A9) 
- 사용 기술: Django(DRF), python, MySQL, javascript, jQuery, Kakao Map API 등

## 세계 요약 현황

### PC
![overview world pc](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/overview_world.png)

### Mobile
<img alt="overview world mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/overview_world.PNG" width="375">

## 국내 요약 현황

### PC
![overview korea pc](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/overview_korea.jpeg)

### Mobile
<img alt="overview korea mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/overview_korea.PNG" width="375">

## 국내 확진자 이동경로

### PC
![route korea pc](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/route.jpeg)

### Mobile
<img alt="route korea mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/route.PNG" width="375">

## 국내 확진자 전파경로

### PC
![tree korea pc](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/tree.jpeg)

### Mobile
<img alt="tree korea mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/tree.PNG" width="375">

## 휴업/폐쇄 현황
### PC
![closed korea pc](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/closed.jpeg)

### Mobile
<img alt="closed korea mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/closed.PNG" width="375">

## 선별진료소 현황
### Mobile
<img alt="hospital korea mobile" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_mobile/hospital.PNG" width="375">

## 운영 어드민
### 메인
![admin main](https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/admin_main.png)

### 항목별 데이터 목록(예시: 국가별 요약 현황)
<img alt="admin detail" src="https://github.com/HyunSangHan/MBC-corona19-archive/blob/master/docs/capture_pc/admin_detail.png" width="600">