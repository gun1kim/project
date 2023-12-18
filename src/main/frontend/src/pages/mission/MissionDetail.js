// import "./MissionDetail.css";
import "../../styles/mission/MissionDetail.css";
import React, {useState, useEffect} from "react";
import ApiClient from "../../components/ApiClient";
import { useParams } from "react-router-dom";
function MissionDetail() {
  let params = useParams();
  let missionId = params.missionId;
  const [mission, setMission] = useState();
  
  function prettyDate() { 
    const startDate = new Date(mission.startAt);
    const endDate = new Date(mission.endAt);

    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit'};

    const prettyStartDate = startDate.toLocaleDateString('ko-KR', options) + ' ' + startDate.toLocaleTimeString('ko-KR');
    const prettyEndDate = endDate.toLocaleDateString('ko-KR', options) +  ' ' + endDate.toLocaleTimeString('ko-KR');
    const result = `${prettyStartDate} ~ ${prettyEndDate}`;
    return result;
  }
 
  useEffect(() => {
    
    console.log(missionId);
    ApiClient.get(`/missions/${missionId}`)
    .then((response) => {
      console.log(response);
      setMission(response.data);
    })
  }, [])

  useEffect(() => {
    console.log(mission)
  }, [mission])

    return (
        <div className="mission-detail-index">
      <div className="header-login">
        <div className="header-wrap">
          <div className="eco-connect-logo">
            <img
              className="img"
              alt="Eco connect logo"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656f39b816e4b95e9e1c32c1/img/eco-connect-logo.png"
            />
          </div>
          <div className="header-menu-wrap">
            <div className="header-menu">
              <div className="text-wrapper">봉사미션</div>
              <div className="text-wrapper">봉사모임</div>
              <div className="reward">리워드</div>
              <div className="funding">펀딩</div>
              <div className="text-wrapper">고객지원</div>
            </div>
          </div>
          <img
            className="header-icons"
            alt="Header icons"
            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/header-icons.svg"
          />
        </div>
      </div>
      <div className="mission-detail-start">
        <div className="div">
          <img
            className="mission-detail-start-2"
            alt="Mission detail start"
            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-detail-start-image.png"
          />
          <div className="mission-detail-start-wrapper">
            <div className="mission-detail-start-3">미션을 시작해 보세요!</div>
          </div>
          <div className="div-wrapper">
            <p className="p">활동형 미션부터 참여형, 도전형 미션까지 다양한 미션을 통해 포인트를 쌓아보세요</p>
          </div>
        </div>
      </div>
      <div className="mission-detail-title">
        <div className="mission-detail-title-2">
          <div className="mission-detail-title-3">쓰레기 줍기</div>
          <img
            className="mission-detail-title-4"
            alt="Mission detail title"
            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-detail-title-hr.svg"
          />
        </div>
      </div>
      <div className="mission-detail-main">
        <div className="mission-detail-main-2">
          <div className="mission-detail-image">
            <img
              className="mission-detail-image-2"
              alt="Mission detail image"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-detail-image.png"
            />
          </div>
          <div className="mission-detail-info">
            <div className="div-wrapper-2">
              <div className="mission-detail">{mission ? mission.title : "Loading..."}</div>
            </div>
            <div className="div-wrapper-2">
              <p className="mission-detail-get">흭득가능 포인트 : {mission ? mission.point : "Loading..."} P</p>
            </div>
            <div className="div-wrapper-2">
              <div className="mission-detail-host">개최자: {mission ? mission.host : "Loading..."}</div>
            </div>
            <div className="div-wrapper-2">
              <div className="mission-detail-2">미션장소: {mission ? `${mission.fullAddress} ${mission.subAddress}` : "Loading..."}</div>
            </div>
            <div className="div-wrapper-2">
              <div className="mission-detail-date">미션일시 {mission ? prettyDate() : "Loading..."}</div>
            </div>
            <div className="mission-detail-wrapper">
              <div className="mission-detail-3">도전하기</div>
            </div>
            <div className="div-wrapper-2">
              <p className="mission-detail-4">※ 미션 인증과정에 오류가 있다면 문의해주시기 바랍니다</p>
            </div>
          </div>
        </div>
      </div>
      <div className="mission-detail-more">
        <div className="mission-detail-more-2">
          <div className="div-wrapper-3">
            <div className="text-wrapper-2">더 많은 미션 참가하기</div>
          </div>
          <div className="div">
            <img
              className="more-hr"
              alt="More hr"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-detail-title-hr.svg"
            />
          </div>
        </div>
      </div>
      <div className="midssion-detail">
        <div className="mission-list-another">
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-1.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-2.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-3.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
        </div>
        <div className="mission-list-another">
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-4.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-5.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-6.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
          <div className="mission-list-wrap">
            <div className="mission-frame">
              <div className="mission-image-wrap">
                <img
                  className="mission-image"
                  alt="Mission image"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715e6bc2e3a066593b0581/img/mission-image-7.svg"
                />
              </div>
              <div className="mission-info">
                <div className="mission-info-wrap">
                  <div className="div-wrapper-3">
                    <div className="mission-name-text">쓰레기 줍기</div>
                  </div>
                  <div className="mission-point">
                    <div className="mission-point-text">10 P</div>
                  </div>
                </div>
              </div>
              <div className="challenge-button">
                <div className="challenge">도전하기</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer className="footer">
        <div className="footer-wrap">
          <div className="logo-wrap">
            <img
              className="img"
              alt="Eco connect logo"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656f39b816e4b95e9e1c32c1/img/eco-connect-logo.png"
            />
          </div>
          <div className="menu-wrap">
            <div className="text-wrapper-3">미용안내</div>
            <div className="text-wrapper-3">공지사항</div>
            <div className="q-a">Q&amp;A</div>
            <div className="text-wrapper-3">이용약관</div>
            <p className="text-wrapper-4">개인정보 수집 및 이용 동의</p>
          </div>
          <div className="inquiry-button-wrap">
            <div className="inquiry">문의하기</div>
            <div className="direct-button">
              <div className="direct">바로가기</div>
            </div>
          </div>
        </div>
      </footer>
    </div>
    )
}

export default MissionDetail;