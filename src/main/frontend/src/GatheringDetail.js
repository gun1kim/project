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
        <div className="index">
            <div className="div">
                <div className="div">
                    <header className="header">
                        <div className="header-logo-wrap">
                            <div className="header-logo" />
                        </div>
                        <img
                            className="header-profile-icon"
                            alt="Header profile icon"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/header-profile-icon-wrap.svg"
                        />
                        <div className="header-mission-wrap">
                            <div className="text-wrapper">봉사미션</div>
                        </div>
                        <div className="header-gathering">
                            <div className="text-wrapper">봉사모임</div>
                        </div>
                        <div className="header-funding-wrap">
                            <div className="text-wrapper">펀딩</div>
                        </div>
                        <div className="header-support-wrap">
                            <div className="text-wrapper">고객지원</div>
                        </div>
                        <img
                            className="header-message-icon"
                            alt="Header message icon"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/header-message-icon-wrap.svg"
                        />
                        <img
                            className="header-noti-icon"
                            alt="Header noti icon"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/header-noti-icon-wrap.svg"
                        />
                    </header>
                    <div className="element">
                        <div className="overlap-group">
                            <img
                                className="icon-leaf"
                                alt="Icon leaf"
                                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/---icon--leaf-@2x.png"
                            />
                        </div>
                        <div className="ECO-CONNECT">
                            ECO
                            <br />
                            CONNECT
                        </div>
                    </div>
                </div>
                <div className="div">
                    <div className="div-2">
                        <div className="div-2">
                            <div className="gathering-join-image">
                                <img
                                    className="img"
                                    alt="Gathering join image"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-join-image.png"
                                />
                            </div>
                            <div className="gathering-join">
                                <div className="overlap-group-2">
                                    <p className="gathering-join-text">
                                        소규모 모임부터 봉사 모임까지 주변 사람들과 모여서 봉사활동을 시작하세요!
                                    </p>
                                    <div className="gathering-join-cover" />
                                    <div className="gathering-join-text-2">모임에 참석해보세요</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="gathreing-detail">
                    <div className="gathering-detail">오리역 봉사모임!!</div>
                    <img
                        className="gathering-detail-2"
                        alt="Gathering detail"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-detail-border.svg"
                    />
                </div>
                <div className="gathering-detail-3">
                    <div className="gathering-detail-wrapper">
                        <div className="gathering-detail-4">
                            <div className="img-wrapper">
                                <img
                                    className="gathering-detail-5"
                                    alt="Gathering detail"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-detail-background.png"
                                />
                            </div>
                            <div className="gathering-detail-6">
                                <div className="gathering-detail-7" />
                                <img
                                    className="gathering-detail-8"
                                    alt="Gathering detail"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-detail-writer-profile@2x.png"
                                />
                                <div className="div-wrapper">
                                    <div className="gathering-detail-9">익명의 모임장</div>
                                </div>
                            </div>
                            <div className="rectangle-wrapper">
                                <div className="rectangle" />
                            </div>
                            <div className="frame" />
                            <div className="gathering-detail-10">
                                <div className="gathering-detail-11">오리역 봉사모임!!</div>
                            </div>
                            <div className="gathering-detail-12">
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
                            <div className="gathering-detail-13">
                                <div className="text-wrapper-2">멤버소개</div>
                            </div>
                            <div className="gathering-detail-14">
                                <div className="gathering-detail-11">우리 반갑게 만나요</div>
                            </div>
                            <div className="gathering-detail-15">
                                <div className="gathering-detail-16">익명의 모임장</div>
                            </div>
                            <div className="gathering-detail-17">
                                <p className="gathering-detail-18">선한영향력을 가진 사람이 되고 싶어요.</p>
                            </div>
                            <div className="gathering-detail-19">
                                <div className="rectangle-2" />
                                <img
                                    className="gathering-preview"
                                    alt="Gathering preview"
                                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-preview-plus-wrap.svg"
                                />
                                <div className="gathering-preview-wrapper">
                                    <p className="gathering-preview-2">함께 할 멤버들을 먼저 확인하고 참여해 보세요!</p>
                                </div>
                                <div className="gathering-preivew">
                                    <div className="gathering-preview-3">
                                        <div className="text-wrapper-3">확인하기</div>
                                    </div>
                                </div>
                            </div>
                            <div className="gathering-gather">
                                <div className="gathering-gather-wrapper">
                                    <div className="text-wrapper-2">안내사항</div>
                                </div>
                                <div className="gathering-gather-wrapper">
                                    <div className="gathering-gather-2">자세한 정보를 알려드릴게요</div>
                                </div>
                                <div className="gathering-gather-num">
                                    <div className="gathering-gather-num-wrapper">
                                        <div className="text-wrapper-3">20명</div>
                                    </div>
                                    <div className="gathering-gather-pos">
                                        <img
                                            className="gathering-gather-pos-2"
                                            alt="Gathering gather pos"
                                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/gathering-gather-pos-icon.svg"
                                        />
                                        <div className="text-wrapper-3">오리역</div>
                                    </div>
                                </div>
                            </div>
                            <div className="gathering-gather-3">
                                <div className="overlap-group-wrapper">

                                    <div className="overlap-group-3">
                                        <button className="gathering-gather-4" onClick={async () => {
                                            try {
                                                const response = await axios.delete(`http://localhost:8080/api/gathering/${gatheringId}`)
                                                console.log(response.data);
                                            } catch(error) {
                                                console.log(error);
                                            }
                                        }}>삭제</button>
                                    </div>
                                </div>
                                <div className="overlap-wrapper">
                                    <div className="overlap">
                                        <button type="button" className="gathering-gather-5">수정</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="gathering-join-wrap">
                        <button type="button" className="gathering-join-text-3">바로 참여 하기</button>
                    </div>
                </div>
                <div className="div">
                    <footer className="footer">
                        <div className="footer-content-wrap">
                            <div className="div-3">
                                <div className="div-3">
                                    <div className="ellipse" />
                                    <div className="ECO-CONNECT-2">
                                        ECO
                                        <br />
                                        CONNECT
                                    </div>
                                    <img
                                        className="icon-leaf-2"
                                        alt="Icon leaf"
                                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656592b669fa33efc3822335/img/---icon--leaf--1@2x.png"
                                    />
                                </div>
                            </div>
                            <div className="footer-menu-wrap">
                                <div className="div-wrapper-2">
                                    <div className="text-wrapper-4">이용안내</div>
                                </div>
                                <div className="div-wrapper-2">
                                    <div className="text-wrapper-4">공지사항</div>
                                </div>
                                <div className="div-wrapper-2">
                                    <div className="text-wrapper-4">Q&amp;A</div>
                                </div>
                                <div className="div-wrapper-2">
                                    <div className="text-wrapper-4">이용약관</div>
                                </div>
                                <div className="footer-privacy-wrap">
                                    <p className="text-wrapper-4">개인정보 수집 및 이용 동의</p>
                                </div>
                            </div>
                            <div className="footer-right-wrap">
                                <div className="footer-inquiry-wrap">
                                    <div className="footer-inquiry">문의하기</div>
                                </div>
                                <div className="footer-button-wrap">
                                    <div className="footer-button-text">바로가기</div>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
    )
}

export default GatheringDetail;
