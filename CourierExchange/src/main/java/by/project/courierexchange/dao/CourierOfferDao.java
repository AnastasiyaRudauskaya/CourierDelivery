package by.project.courierexchange.dao;


import java.util.List;

public interface ClientOfferDao {
    int insert(ClientOffer clientOffer) throws DaoException;

    List<ClientOffer> findByUserAndStatus(User user, OfferStatusType status) throws DaoException;

    List<ClientOffer> findByStatus(OfferStatusType status) throws DaoException;

    void changeStatus(int offerId, OfferStatusType status) throws DaoException;

    void delete(int offerId) throws DaoException;

    void deleteGoods(int offerId) throws DaoException;
}