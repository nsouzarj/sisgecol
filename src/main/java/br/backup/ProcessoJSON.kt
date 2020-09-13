package br.backup

class ProcessoJSON {
    var id: String? = null
    var originAreaId: String? = null
    var responsibleAreaId: String? = null
    var legalDepartmentAreaId: String? = null
    var requesterId: String? = null
    var natureId: String? = null
    var folder: String? = null
    var courtId: String? = null
    var courtName: String? = null
    var actionTypeId: String? = null
    var actionTypeName: String? = null
    var identifierNumber: String? = null
    var oldNumber: String? = null
    var statusId: String? = null
    var countryId: String? = null
    var stateId: String? = null
    var cityId: String? = null
    var individual: String? = null
    var individualName: String? = null
    var company: String? = null
    var companyName: String? = null
    var otherParty: List<OutraParteJSON>? = null
    var name1: String? = null
    var otherPartyName: String? = null
    var customer: List<ClienteJSON>? = null
    var name2: String? = null
    var customerName: String? = null

    override fun toString(): String {
        return ("ProcessoJSON [id=" + id + ", originAreaId=" + originAreaId + ", responsibleAreaId=" + responsibleAreaId
                + ", legalDepartmentAreaId=" + legalDepartmentAreaId + ", requesterId=" + requesterId + ", natureId="
                + natureId + ", folder=" + folder + ", courtId=" + courtId + ", courtName=" + courtName
                + ", actionTypeId=" + actionTypeId + ", actionTypeName=" + actionTypeName + ", identifierNumber="
                + identifierNumber + ", oldNumber=" + oldNumber + ", statusId=" + statusId + ", countryId=" + countryId
                + ", stateId=" + stateId + ", cityId=" + cityId + ", individual=" + individual + ", individualName="
                + individualName + ", company=" + company + ", companyName=" + companyName + ", otherParty="
                + otherParty + ", name1=" + name1 + ", otherPartyName=" + otherPartyName + ", customer=" + customer
                + ", name2=" + name2 + ", customerName=" + customerName + "]")
    }
}