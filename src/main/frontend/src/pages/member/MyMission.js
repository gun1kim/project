import "../../styles/member/MyMission.css";

function MyMission() {

    return (
        <div className="my-mission-index">
      <div className="my-mission-wrap-wrapper">
        <div className="my-mission-wrap">
          <div className="mypage-sidebar-wrap">
            <div className="sidebar-frame">
              <div className="sidebar" />
            </div>
            <div className="sidebar-shortcut">
              <div className="favicon-logo">
                <img
                  className="icon-leaf"
                  alt="Icon leaf"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581278e47a45727e508871b/img/---icon--leaf-@2x.png"
                />
              </div>
              <div className="shortcut-mission">
                <img
                  className="favicon-mission"
                  alt="Favicon mission"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/658127c6f56d898df5822bb6/img/favicon-mission.svg"
                />
                <div className="menu-name">미션</div>
              </div>
              <div className="shortcut-volunteer">
                <img
                  className="favicon-volunteer"
                  alt="Favicon volunteer"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/658127c6f56d898df5822bb6/img/favicon-volunteer.svg"
                />
                <div className="menu-name">모임</div>
              </div>
              <div className="shortcut-funding">
                <img
                  className="favicon-funding"
                  alt="Favicon funding"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581278e47a45727e508871b/img/favicon-funding.svg"
                />
                <div className="menu-name">펀딩</div>
              </div>
              <div className="shoftcut-rank">
                <img
                  className="favicon-rank"
                  alt="Favicon rank"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/658127c6f56d898df5822bb6/img/favicon-rank.svg"
                />
                <div className="menu-name">랭킹</div>
              </div>
              <div className="shortcut-qna">
                <img
                  className="favicon-qna"
                  alt="Favicon qna"
                  src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/658127c6f56d898df5822bb6/img/favicon-qna.svg"
                />
                <div className="menu-name">문의</div>
              </div>
              <div className="shoftcut-logout">
                <div className="favicon-logout">
                  <img
                    className="icon-logout"
                    alt="Icon logout"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581278e47a45727e508871b/img/---icon--logout-@2x.png"
                  />
                  <div className="text-wrapper">로그아웃</div>
                </div>
              </div>
            </div>
          </div>
          <div className="my-mission-right">
            <div className="div">
              <div className="div">
                <div className="serach-box">
                  <div className="search-icon-wrap">
                    <img
                      className="search-icon"
                      alt="Search icon"
                      src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6570992a80abe6b84bdfe96b/img/menu-search-icon.png"
                    />
                  </div>
                </div>
              </div>
              <img
                className="header-icon-wrap"
                alt="Header icon wrap"
                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/header-icon-wrap.svg"
              />
            </div>
            <div className="my-mission-main-wrap">
              <div className="div">
                <div className="my-mission-info">
                  <div className="div-2">
                    <div className="my-mission-text">
                      <div className="text-wrapper-2">나의 미션</div>
                      <div className="rectangle" />
                    </div>
                    <div className="status">
                      <div className="status-blank" />
                      <div className="my-mission-url">
                        <div className="text-wrapper-3">Home</div>
                        <div className="direction"></div>
                        <div className="text-wrapper-3">MISSION</div>
                      </div>
                    </div>
                  </div>
                  <div className="div-3">
                    <div className="div-4">
                      <div className="div-5">
                        <div className="bg" />
                        <div className="artwork"></div>
                      </div>
                      <div className="div-6">
                        <div className="text-wrapper-4">20</div>
                        <div className="text-wrapper-5">진행중인 미션</div>
                      </div>
                    </div>
                    <div className="my-mission-complete">
                      <div className="div-5">
                        <div className="bg-2" />
                        <div className="artwork"></div>
                      </div>
                      <div className="div-6">
                        <div className="text-wrapper-4">12</div>
                        <div className="text-wrapper-6">완료한 미션</div>
                      </div>
                    </div>
                    <div className="div-4">
                      <div className="div-5">
                        <div className="bg-3" />
                        <div className="artwork"></div>
                      </div>
                      <div className="div-6">
                        <div className="text-wrapper-4">200</div>
                        <p className="p">
                          <span className="span">누적 포인트&nbsp;&nbsp;&nbsp;&nbsp;</span>
                          <span className="text-wrapper-7">상세보기</span>
                        </p>
                      </div>
                    </div>
                    <div className="div-4">
                      <div className="div-5">
                        <div className="bg-4" />
                        <div className="artwork"></div>
                      </div>
                      <div className="div-6">
                        <div className="text-wrapper-8">2</div>
                        <div className="text-wrapper-9">실패한 미션</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="status-row">
                <div className="div-wrapper">
                  <div className="text-wrapper-10">진행중인 미션</div>
                </div>
                <div className="div-2">
                  <div className="th">
                    <div className="frame">
                      <div className="checkbox-none">
                        <div className="checkbox" />
                      </div>
                      <div className="text-wrapper-11">미션 리스트</div>
                      <div className="text-wrapper-12">흭득가능 포인트</div>
                      <div className="text-wrapper-13">주최자</div>
                      <div className="text-wrapper-14">남은시간</div>
                      <div className="text-wrapper-15">Action</div>
                    </div>
                  </div>
                  <div className="split-wrapper">
                    <img
                      className="split"
                      alt="Split"
                      src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/split.svg"
                    />
                  </div>
                </div>
                <div className="my-mission-current">
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                  <div className="my-mission-list-wrap">
                    <div className="my-mission-list">
                      <div className="checkbox-wrapper">
                        <div className="checkbox" />
                      </div>
                      <div className="my-mission-image" />
                      <div className="my-mission-title-and">
                        <div className="my-mission-title">
                          <div className="text-wrapper-16">쓰레기 1개 줍기</div>
                        </div>
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-17">성남시</div>
                        </div>
                      </div>
                      <div className="div-wrapper-2">
                        <p className="element-p">
                          <span className="text-wrapper-18">10 </span>
                          <span className="text-wrapper-19">P</span>
                        </p>
                      </div>
                      <div className="my-mission-host">
                        <img
                          className="img"
                          alt="My mission host"
                          src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-host-profile.svg"
                        />
                        <div className="div-wrapper-2">
                          <div className="text-wrapper-20">에코커넥트</div>
                        </div>
                      </div>
                      <div className="div-wrapper">
                        <p className="text-wrapper-21">2 Hours 1 min 30s</p>
                      </div>
                      <div className="my-mission-post">
                        <div className="text-wrapper-22">인증</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="div-3">
                  <div className="my-mission-delete" />
                  <div className="div">
                    <img
                      className="my-mission-delete-2"
                      alt="My mission delete"
                      src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/6581291fac10584c0429bbee/img/my-mission-delete.svg"
                    />
                    <div className="text-wrapper-23">미션삭제</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    );
}

export default MyMission;