<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- ========================= JS here ========================= -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/tiny-slider.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/glightbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/count-up.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
    <script type="text/javascript">
        //====== Clients Logo Slider
        tns({
            container: '.client-logo-carousel',
            slideBy: 'page',
            autoplay: true,
            autoplayButtonOutput: false,
            mouseDrag: true,
            gutter: 15,
            nav: false,
            controls: false,
            responsive: {
                0: {
                    items: 1,
                },
                540: {
                    items: 3,
                },
                768: {
                    items: 4,
                },
                992: {
                    items: 4,
                },
                1170: {
                    items: 6,
                }
            }
        });
    </script>