import React from "react";
import "./Root.css";
import "./GatheringDetail.css";
import {Link} from "react-router-dom";
import axios from "axios";
import { useParams} from "react-router-dom";

function GatheringDetail() {

    let params = useParams();

    let gatheringId = params.gatheringId;

    return (
        <div className="detail-index">
            <div className="div">
                <div className="footer-wrap">
                    <div className="footer-logo-wrap">
                        <div className="footer-image-wrap" />
                    </div>
                    <div className="footer-menu-wrap">
                        <div className="div-wrapper">
                            <div className="text-wrapper">이용안내</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">공지사항</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">Q&amp;A</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">이용약관</div>
                        </div>
                        <div className="footer-privacy-wrap">
                            <p className="footer-privacy">개인정보 수집 및 이용 동의</p>
                        </div>
                    </div>
                    <div className="footer-inquiry-wrap">
                        <div className="footer-inquiry">문의하기</div>
                    </div>
                    <div className="footer-button-wrap">
                        <div className="footer-button">
                            <div className="footer-button-text">바로가기</div>
                        </div>
                    </div>
                </div>
                <div className="overlap-group">
                    <div className="detail-main-wrap">
                        <div className="detail-main">
                            <img
                                className="nature"
                                alt="Nature"
                                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/nature-3289812-1920-2.png"
                            />
                            <div className="detail-main-writer">
                                <div className="detail-writer">익명의 서포터</div>
                                <div className="detail-title">오리역 봉사모임!!</div>
                            </div>
                            <div className="detail-main-content">
                                <p className="p">
                                    🙋호스트를 소개해요!
                                    <br /> -안녕하세요, 책을 통해 발전하고싶은 성장에 미쳐있는 옐리입니다.
                                    <br /> <br />
                                    👟이런 활동을 할 거예요!
                                    <br /> - 혼자 읽을땐 눈치가 보여 선행을 선뜻하지 못했지만 함께라면 가능해요.
                                    <br /> - 선정한 봉사 소개와 선정이유-&gt;봉사-&gt;깨달은 것 나누기
                                    <br /> - 선행를 통해 모두가 1cm라도 성장하길 바랍니다.
                                    <br /> - 각자 먹을 소소한 간식도 챙겨오셔도됩니다. <br />
                                    <br />
                                    🙆이런 멤버와 함께하고 싶어요!
                                    <br /> - 서로를 배려하고 모임에 활발하게 참여하실 수 있는 멤버를 원해요!
                                    <br />
                                    <br /> 📢공지사항도 확인해주세요!
                                    <br /> - 참가비는 장소대관비, 모임운영비로 사용됩니다
                                </p>
                            </div>
                            <div className="detail-main-sum-wrap">
                                <div className="text-wrapper-2">멤버소개</div>
                                <div className="detail-main-hello">우리 반갑게 만나요</div>
                                <div className="detail-main-gather">익명의 모임장</div>
                                <p className="detail-main-gather-2">선한영향력을 가진 사람이 되고 싶어요.</p>
                            </div>
                            <div className="detail-main-check">
                                <img
                                    className="img"
                                    alt="Detail main check"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/detail-main-check-plus.svg"
                                />
                                <p className="detail-main-check-2">함께 할 멤버들을 먼저 확인하고 참여해 보세요!</p>
                                <div className="detail-main-check-wrapper">
                                    <div className="detail-main-check-3">확인하기</div>
                                </div>
                            </div>
                            <div className="detail-main-info">
                                <div className="text-wrapper-2">안내사항</div>
                                <div className="detail-main-details">자세한 정보를 알려드릴게요</div>
                                <div className="detail-people-wrap">
                                    <img
                                        className="img-2"
                                        alt="Detail people icon"
                                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/detail-people-icon.svg"
                                    />
                                    <div className="detail-people-text">20명</div>
                                </div>
                                <div className="detail-location-wrap">
                                    <img
                                        className="img-2"
                                        alt="Detail locaion icon"
                                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/detail-locaion-icon.svg"
                                    />
                                    <div className="detail-location-text">오리역</div>
                                    <div className="detail-blank" />
                                    <div className="detail-buttons">
                                        <div className="detail-update-button">
                                            <div className="text-wrapper-3">수정</div>
                                        </div>
                                        <div className="detail-delete-button">
                                            <div className="text-wrapper-3">삭제</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="detail-join-button">
                                <div className="detail-join-text">바로 참여 하기</div>
                            </div>
                        </div>
                    </div>
                    <img
                        className="profile-icon"
                        alt="Profile icon"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/profile-icon.svg"
                    />
                </div>
                <div className="gathering-title">
                    <div className="title">오리역 봉사모임!</div>
                </div>
                <div className="gathering-banner">
                    <img
                        className="nature-2"
                        alt="Nature"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/nature-3289812-1920-2-1.png"
                    />
                    <div className="banner-text-big">모임에 참석해 보세요!</div>
                    <p className="banner-text-small">소규모 모임부터 봉사 모임까지 주변 사람들과 모여서 봉사활동을 시작하세요!</p>
                </div>
                <div className="header-wrap">
                    <header className="header">
                        <div className="header-logo-wrap">
                            <div className="logo-wrap">
                                <div className="ellipse" />
                                <div className="ECO-CONNECT">
                                    ECO
                                    <br />
                                    CONNECT
                                </div>
                                <img
                                    className="icon-leaf"
                                    alt="Icon leaf"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/---icon--leaf-@2x.png"
                                />
                            </div>
                        </div>
                        <div className="header-menu-wrap">
                            <div className="header-mission-wrap">
                                <div className="text-wrapper-4">봉사미션</div>
                            </div>
                            <div className="div-wrapper-2">
                                <div className="text-wrapper-4">봉사모임</div>
                            </div>
                            <div className="div-wrapper-2">
                                <div className="text-wrapper-4">펀딩</div>
                            </div>
                            <div className="div-wrapper-2">
                                <div className="text-wrapper-4">고객지원</div>
                            </div>
                        </div>
                        <img
                            className="header-icon-wrap"
                            alt="Header icon wrap"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656794b954eecaa3161d736b/img/header-icon-wrap.svg"
                        />
                    </header>
                </div>
            </div>
        </div>
    )
}

export default GatheringDetail;
