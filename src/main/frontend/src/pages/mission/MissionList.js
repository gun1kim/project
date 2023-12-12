import "../../styles/mission/MissionList.css";
import React from "react";

function MissionList() {

    return (
        <div className="mission-list-index">
      <div className="mission-list-wrap-wrapper">
        <div className="mission-list-wrap">
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
                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/header-icons.svg"
              />
            </div>
          </div>
          <div className="mission-image-wrap">
            <img
              className="mission-image"
              alt="Mission image"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image.png"
            />
          </div>
          <div className="mission-middle-menu">
            <div className="menu-select">
              <div className="menu-total">
                <div className="div">전체&nbsp;&nbsp;&nbsp;&nbsp; |</div>
              </div>
              <div className="menu-activity">
                <div className="div-2">
                  <img
                    className="img-2"
                    alt="Menu activity icon"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/menu-activity-icon.png"
                  />
                </div>
                <div className="div-2">
                  <div className="div">활동형&nbsp;&nbsp;&nbsp;&nbsp; |</div>
                </div>
              </div>
              <div className="div-3">
                <div className="div-4">
                  <img
                    className="img-2"
                    alt="Menu participate"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/menu-participate-icon.png"
                  />
                </div>
                <div className="div-4">
                  <div className="div">참여형&nbsp;&nbsp;&nbsp;&nbsp; |</div>
                </div>
              </div>
              <div className="div-3">
                <div className="div-5">
                  <img
                    className="img-2"
                    alt="Menu challenge icon"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/menu-challenge-icon.png"
                  />
                </div>
                <div className="div-5">
                  <div className="div">도전형</div>
                </div>
              </div>
            </div>
            <div className="middle-menu-blank" />
            <div className="menu-search">
              <div className="menu-search-wrap">
                <div className="menu-search-input" />
                <div className="placeholder">Search Here</div>
                <div className="menu-search-icon">
                  <img
                    className="menu-search-icon-2"
                    alt="Menu search icon"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/menu-search-icon.png"
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="hr-wrap">
            <img
              className="hr"
              alt="Hr"
              src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/hr.svg"
            />
          </div>
          <div className="main-wrap">
            <div className="main-info">
              <div className="div-6">
                <div className="my-profile-wrap">
                  <div className="my-profile">
                    <div className="my-profile-image">
                      <div className="profile-image">
                        <img
                          className="profile-image-2"
                          alt="Profile image"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/profile-image@2x.png"
                        />
                      </div>
                    </div>
                    <div className="my-profile-info-wrap">
                      <div className="username-info-wrap">
                        <img
                          className="main-account"
                          alt="Main account"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/main-account.svg"
                        />
                        <div className="username-info">
                          <div className="div-4">
                            <div className="username">User Name</div>
                          </div>
                          <img
                            className="status-wrap"
                            alt="Status wrap"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/status-wrap.svg"
                          />
                        </div>
                      </div>
                      <div className="profile-detail">
                        <div className="profile-nickname">
                          <div className="nickname">Nickname</div>
                        </div>
                        <div className="profile-info-wrap">
                          <div className="profile-info">
                            <div className="profile-grade">서포터</div>
                          </div>
                          <div className="profile-hold">
                            <div className="text-wrapper-2">보유금액</div>
                          </div>
                          <div className="my-holding-wrap">
                            <div className="my-holding">100 WON</div>
                          </div>
                        </div>
                        <div className="div-2">
                          <div className="my-point-blank" />
                          <div className="my-point-text-wrap">
                            <div className="text-wrapper-2">포인트</div>
                          </div>
                          <div className="div-2">
                            <div className="my-point-hold">300 P</div>
                          </div>
                        </div>
                      </div>
                      <div className="my-profile-button">
                        <div className="donation-list-button">
                          <div className="text-wrapper-3">후원목록</div>
                        </div>
                        <div className="mypage-button">
                          <div className="text-wrapper-3">마이페이지</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="main-new-challenge">
                  <div className="main-image-wrap">
                    <img
                      className="main-image"
                      alt="Main image"
                      src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/main-image.png"
                    />
                  </div>
                  <div className="image-info-wrap">
                    <div className="div-2">
                      <div className="image-info-text-big">새로운 도전을 시작해보세요</div>
                    </div>
                    <div className="div-2">
                      <p className="image-info-text">
                        개인 후원부터 제품・콘텐츠・서비스 출시, 성장까지 에코커넥트가 함께할게요
                      </p>
                    </div>
                    <div className="div-6">
                      <div className="image-button-wrap">
                        <div className="explore-button">
                          <div className="text-wrapper-4">Explore</div>
                        </div>
                        <button className="create-button">
                          <div className="text-wrapper-4">Create</div>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="mission-list-wrap-2">
              <div className="mission-list">
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-1.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-2.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-3.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-4.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="mission-list">
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-5.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-6.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-7.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-8.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="mission-list">
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-9.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-10.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-11.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
                <div className="mission-frame-wrapper">
                  <div className="mission-frame">
                    <div className="mission-image-wrapper">
                      <img
                        className="mission-image-2"
                        alt="Mission image"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/mission-image-12.svg"
                      />
                    </div>
                    <div className="mission-info">
                      <div className="mission-info-wrap">
                        <div className="div-2">
                          <div className="mission-name-text">쓰레기 줍기</div>
                        </div>
                        <div className="mission-point">
                          <div className="mission-point-text">10 P</div>
                        </div>
                      </div>
                    </div>
                    <div className="challenge-button">
                      <div className="text-wrapper-4">도전하기</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="pagination-button">
              <div className="pagination-left-wrap">
                <div className="pagination-left">
                  <img
                    className="img-3"
                    alt="Double left"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/double-left@2x.png"
                  />
                </div>
              </div>
              <div className="pagination">
                <div className="text-wrapper-5">1</div>
              </div>
              <div className="pagination-num">
                <div className="element">2</div>
              </div>
              <div className="pagination">
                <div className="text-wrapper-5">3</div>
              </div>
              <div className="pagination">
                <div className="text-wrapper-5">4</div>
              </div>
              <div className="pagination">
                <div className="text-wrapper-5">5</div>
              </div>
              <div className="pagination-right">
                <div className="double-right-wrapper">
                  <img
                    className="img-3"
                    alt="Double right"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65715de20811290773747d5e/img/double-right@2x.png"
                  />
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
                <div className="text-wrapper-6">미용안내</div>
                <div className="text-wrapper-6">공지사항</div>
                <div className="q-a">Q&amp;A</div>
                <div className="text-wrapper-6">이용약관</div>
                <p className="p">개인정보 수집 및 이용 동의</p>
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
      </div>
    </div>
    )
}

export default MissionList;